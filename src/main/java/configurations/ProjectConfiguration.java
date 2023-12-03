package configurations;

import entities.Account;
import entities.Customer;
import model.impl.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.Set;

@Configuration
@ComponentScan(basePackages = "entities")
public class ProjectConfiguration {

    @Bean
    @Primary
    public Account account() {
        Account account = new Account();
        account.setName("New Account");
        return account;
    }

    @Bean
    public Account otherAccount() {
        Account account = new Account();
        account.setName("Account");
        return account;
    }

    /*
    @Bean
    @Primary
    public Customer customerWithAccount() {
        Customer customer = new Customer();
        customer.setName("Customer");
        customer.setAccount(account());     //Sets reference between Customer - Account
        return customer;
    }

    @Bean
    @Primary
    public Customer customerWithAccount(Account account) { //Second way to set a reference between 2 beans.
        Customer customer = new Customer();
        customer.setName("Customer");
        //customer.setAccount(account);     //Sets reference between Customer - Account
        return customer;
    }
     */

    @Bean
    @Primary
    public Customer customerWithAccount(
             Account account) { //Third way to set a reference between 2 beans.
        Customer customer = new Customer(account);
        customer.setName("Customer");
        return customer;
    }

    @Bean
    @Primary
    public PersonImpl person(Set<CreditCardImpl> creditCards, Set<DebitCardImpl> debitCards,
                            Set<AccountImpl> accounts, Set<TransactionImpl> transactions, Set<LoanImpl> loans) {
        PersonImpl person = new PersonImpl();
        person.getAssociatedCreditCards().addAll(creditCards);
        person.getAssociatedDebitCards().addAll(debitCards);
        person.getAssociatedAccounts().addAll(accounts);
        person.getAssociatedTransactions().addAll(transactions);
        person.getAssociatedLoans().addAll(loans);
        return person;
    }

    /*
    @Bean
    Customer customer() {
        Customer customer = new Customer();
        customer.setName("Jon");
        return customer;
    }

    @Bean(name = "Jimmy")
    Customer firstCustomer() {
        Customer customer = new Customer();
        customer.setName("Jimmy");
        return customer;
    }

    @Bean
    Customer secondCustomer() {
        Customer customer = new Customer();
        customer.setName("James");
        return customer;
    }

    @Bean
    Customer thirdCustomer() {
        Customer customer = new Customer();
        customer.setName("Howard");
        return customer;
    }

    @Bean
    String hello() {
        return "Hello";
    }

    @Bean
    Integer ten() {
        return 10;
    }
     */

}
