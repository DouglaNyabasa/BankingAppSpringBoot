package com.example.bankingApp.serviceImpl;

import com.example.bankingApp.dto.AccountDto;
import com.example.bankingApp.exception.OperationNonPermittedException;
import com.example.bankingApp.model.Account;
import com.example.bankingApp.repository.AccountRepository;
import com.example.bankingApp.service.AccountService;
import com.example.bankingApp.validator.ObjectsValidator;
import org.iban4j.CountryCode;
import org.iban4j.Iban;
import org.springframework.stereotype.Service;

import javax.naming.OperationNotSupportedException;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final ObjectsValidator<AccountDto> objectsValidator;

    public AccountServiceImpl(AccountRepository accountRepository, ObjectsValidator<AccountDto> objectsValidator) {
        this.accountRepository = accountRepository;
        this.objectsValidator = objectsValidator;
    }

    @Override
    public Integer save(AccountDto dto) {
        objectsValidator.validate(dto);
        Account account = AccountDto.toEntity(dto);
        boolean userAccountAlreadyExist = accountRepository.findByUserId(Math.toIntExact(account.getUser().getId())).isPresent();
        if (userAccountAlreadyExist && account.getUser().isActive()){
            throw new OperationNonPermittedException(
                    "the selected user has already an active account",
                    "Create account",
                    "Account service",
                    "Account creation"
            );
        }
        if (dto.getId()==null){
            account.setIban(generateRandomIban());
        }
        return Math.toIntExact(accountRepository.save(account).getId());
    }

    private String generateRandomIban() {
        String iban = Iban.random(CountryCode.DE).toFormattedString();
        boolean ibanExists = accountRepository.findByIban(iban).isPresent();
        if (ibanExists) {
            generateRandomIban();
        }
        // if not exist -> return generated iban
        return iban;
    }

    @Override
    public List<AccountDto> findAll() {

        return accountRepository.findAll()
                .stream()
                .map(AccountDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public AccountDto findById(Long id) {
        return accountRepository.findById(id)
                .map(AccountDto::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException("No account was found with the ID : " + id));
    }

    @Override
    public void delete(Long id) {
        accountRepository.deleteById(id);

    }
}
