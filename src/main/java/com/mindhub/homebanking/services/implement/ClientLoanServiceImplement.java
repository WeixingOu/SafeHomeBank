package com.mindhub.homebanking.services.implement;

import com.mindhub.homebanking.models.Client;
import com.mindhub.homebanking.models.ClientLoan;
import com.mindhub.homebanking.models.Loan;
import com.mindhub.homebanking.repositories.ClientLoanRepository;
import com.mindhub.homebanking.services.ClientLoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientLoanServiceImplement implements ClientLoanService {

    @Autowired
    private ClientLoanRepository clientLoanRepository;

    @Override
    public ClientLoan findById(Long id) {
        return clientLoanRepository.findById(id).orElse(null);
    }

    @Override
    public boolean existsByClientAndLoanAndActive(Client client, Loan loan, boolean active) {
        return clientLoanRepository.existsByClientAndLoanAndActive(client, loan, active);
    }

    @Override
    public void saveClientLoan(ClientLoan clientLoan) {
        clientLoanRepository.save(clientLoan);
    }
}