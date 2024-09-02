package com.aop.demo;

import com.aop.demo.dao.AccountDAO;
import com.aop.demo.dao.MembershipDAO;
import com.aop.demo.service.TrafficeFortuneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication(exclude = JmxAutoConfiguration.class)
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO, MembershipDAO membershipDAO, TrafficeFortuneService trafficeFortuneService) {
		return runner -> {
			System.out.println("Hello World!");
			// demoTheBeforeAdvice(accountDAO, membershipDAO);
			// demoTheAfterReturnAdvice(accountDAO);
			// demoTheAfterThrowingAdvice(accountDAO);
			// demoTheAfterAdvice(accountDAO);
			// demoTheAroundAdvice(trafficeFortuneService);
			// demoTheAroundAdviceException(trafficeFortuneService);
			demoTheAroundAdviceRethrowException(trafficeFortuneService);
		};
	}

	public void demoTheBeforeAdvice(AccountDAO accountDAO, MembershipDAO membershipDAO) {
		Account account = new Account();
		account.setName("Testing");
		account.setLevel("Level 4");
		accountDAO.addAccount(account, true);
		accountDAO.addAccount(account, false);
		membershipDAO.addMember();
		membershipDAO.addMember();
		accountDAO.doWork();
		membershipDAO.goToSleep();

		accountDAO.setName("name");
		accountDAO.setServiceCode("123");

		String name = accountDAO.getName();
		String code = accountDAO.getServiceCode();
	}

	public void demoTheAfterReturnAdvice(AccountDAO accountDAO) {
		List<Account> accounts = accountDAO.findAccounts();
		System.out.println("Main Program: demoTheAfterReturnAdvice");
		System.out.println("----");
		System.out.println(accounts);
		System.out.println("\n");
	}

	public void demoTheAfterThrowingAdvice(AccountDAO accountDAO) {
		List<Account> accounts = null;

		try {
			boolean tripWire = true;
			accounts = accountDAO.findAccounts(tripWire);
		} catch (Exception e) {
			System.out.println("Exception : " + e);
		}
		System.out.println("Main Program: demoteAfterThrowingAdvice");
		System.out.println("----");
		System.out.println(accounts);
		System.out.println("\n");
	}

	private void demoTheAfterAdvice(AccountDAO accountDAO) {
		List<Account> accounts = null;

		try {
			boolean tripWire = false;
			accounts = accountDAO.findAccounts(tripWire);
		} catch (Exception e) {
			System.out.println("Exception : " + e);
		}
		System.out.println("Main Program: demoteAfterThrowingAdvice");
		System.out.println("----");
		System.out.println(accounts);
		System.out.println("\n");
	}

	private void demoTheAroundAdvice(TrafficeFortuneService trafficeFortuneService) {
		System.out.println("Main Program: demoTheAroundAdvice");
		System.out.println("----");
		String data = trafficeFortuneService.getFortune();
		System.out.println("Fortune : " + data);
	}

	private void demoTheAroundAdviceException(TrafficeFortuneService trafficeFortuneService) {
		System.out.println("Main Program: demoTheAroundAdviceException");
		System.out.println("----");
		boolean tripWire = true;
		String data = trafficeFortuneService.getFortune(tripWire);
		System.out.println("Fortune : " + data);
	}

	private void demoTheAroundAdviceRethrowException(TrafficeFortuneService trafficeFortuneService) {
		System.out.println("Main Program: demoTheAroundAdviceRethrowException");
		System.out.println("----");
		boolean tripWire = true;
		String data = trafficeFortuneService.getFortune(tripWire);
		System.out.println("Fortune : " + data);
	}
}
