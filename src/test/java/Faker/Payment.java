package Faker;

import com.github.javafaker.Faker;
import com.github.javafaker.Finance;

import static Faker.Base.randomElement;

public class Payment extends Finance {

    public Payment(Faker faker) {
        super(faker);
    }

    Faker faker = new Faker();

    public String ibanNumber(String countryCode) {
        return faker.finance().iban(countryCode);
    }

    protected String banks[] = {
            "Aareal Bank Aktiengesellschaft",
            "Alior Bank SA",
            "Banco Espirito Santo de Investimento",
            "Banco Mais S.A. (SA) Oddział w Polsce",
            "Bank BPH SA",
            "Bank DnB NORD Polska SA",
            "Bank Gospodarki Żywnościowej SA",
            "Bank Gospodarstwa Krajowego",
            "Bank Handlowo - Kredytowy SA",
            "Bank Handlowy w Warszawie SA",
            "Bank Millennium SA",
            "Bank Ochrony Środowiska SA",
            "Bank of China (Luxembourg)S.A",
            "Bank of Tokyo-Mitsubishi UFJ (Polska) SA",
            "Bank Pocztowy SA",
            "Bank Polska Kasa Opieki SA",
            "BANK POLSKIEJ SPÓŁDZIELCZOŚCI SA",
            "Bank Zachodni WBK SA",
            "Banque PSA Finance SA Oddział w Polsce",
            "BNP PARIBAS BANK POLSKA SA",
            "BNP PARIBAS SA Oddział w Polsce",
            "BNP Paribas Securities Services",
            "BPI Bank Polskich Inwestycji SA",
            "BRE Bank Hipoteczny SA",
            "BRE Bank SA",
            "CAIXABANK, S.A",
            "Citibank Europe plc",
            "Credit Agricole Bank Polska SA",
            "CREDIT SUISSE (LUXEMBOURG)",
            "Danske Bank A/S SA Oddział w Polsce",
            "Deutsche Bank PBC SA",
            "Deutsche Bank Polska SA",
            "DZ BANK Polska SA",
            "Elavon Financial Services Limited",
            "Euro Bank SA",
            "EUROCLEAR Bank SA/NV",
            "FCE Bank Polska SA",
            "Fiat Bank Polska SA",
            "FM Bank SA",
            "Getin Noble Bank SA",
            "HSBC Bank Polska SA",
            "Idea Bank SA",
            "Ikano Bank GmbH (Sp. z o.o.) Oddział w Polsce",
            "Industrial and Commercial Bank",
            "ING Bank Śląski SA",
            "Intesa Sanpaolo S.p.A.",
            "INVEST - BANK SA",
            "J.P. Morgan Europe Limited",
            "Mercedes-Benz Bank Polska SA",
            "Meritum Bank ICB SA",
            "Narodowy Bank Polski",
            "Nordea Bank AB SA Oddział w Polsce",
            "NORDEA BANK POLSKA SA",
            "Nykredit Realkredit A/S",
            "Pekao Bank Hipoteczny SA",
            "Polski Bank Przedsiębiorczości SA",
            "Powszechna Kasa Oszczędności Bank",
            "Rabobank Polska SA",
            "Raiffeisen Bank Polska SA",
            "RBS Bank (Polska) SA",
            "RCI Banque Spółka Akcyjna Oddział w Polsce",
            "Santander Consumer Bank SA",
            "Saxo Bank A/S Spółka Akcyjna Oddział w Polsce",
            "SGB-Bank SA",
            "Skandinaviska Enskilda Banken AB",
            "Societe Generale SA Oddział w Polsce",
            "Svenska Handelsbanken AB SA Oddział w Polsce",
            "Sygma Banque Societe Anonyme",
            "Toyota Bank Polska SA",
            "UBS Limited",
            "Vanquis Bank Limited",
            "VOLKSWAGEN BANK POLSKA SA",
    };

    public String PLbank() {
        return randomElement(this.banks);
    }
}
