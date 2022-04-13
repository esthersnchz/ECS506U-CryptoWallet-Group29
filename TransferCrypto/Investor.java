package TransferCrypto;

import java.util.ArrayList;



    public class Investor {
        private String userName;
        private String password;
        private ArrayList<Wallet> wallets;
        private String recoveryPhrase;
        private ArrayList<Transaction> transactions;
        private String firstName;
        private String lastName;


        Investor(String userName, String password, String recoveryPhrase, String firstName, String lastName) {
            this.userName = userName;
            this.password = password;
            this.wallets = new ArrayList<Wallet>();
            this.recoveryPhrase = recoveryPhrase;
            this.transactions = new ArrayList<Transaction>();
            this.firstName = firstName;
            this.lastName = lastName;
        }

        /*getters*/
        public String getRecoveryPhrase() {
            return recoveryPhrase;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getPassword() {
            return password;
        }

        public String getUserName() {
            return userName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getLastName() {
            return lastName;
        }

        public String getFirstName() {
            return firstName;
        }

        public ArrayList<Transaction> getTransactionHistory() {
            return transactions;
        }

        public ArrayList<Wallet> getWallets() {
            return wallets;
        }

        //return an arraylist of all wallet names
        public ArrayList<String> getWalletNames() {
            ArrayList<String> walletNames = new ArrayList<>();
            for (int i = 0; i < this.wallets.size(); i++) {
                walletNames.add(this.wallets.get(i).getWalletName());
            }
            return walletNames;
        }

        //method to get one wallet from the arrayList of wallets by name
        public Wallet getOneWallet(String walletName) {
            Wallet wallet = null;
            for (int i = 0; i < this.wallets.size(); i++) {
                if (this.wallets.get(i).getWalletName().equals(walletName)) {
                    wallet = wallets.get(i);
                }
            }
            return wallet;
        }

        public String getWalletsBalance() {
            String str = "";
            for (int i = 0; i < this.wallets.size(); i++) {
                str += this.wallets.get(i).getWalletName();
                str += " " + this.wallets.get(i).getCryptos() + "\n";
            }
            return str;
        }

        /*setters*/
        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public void setRecoveryPhrase(String recoveryPhrase) {
            this.recoveryPhrase = recoveryPhrase;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public void setWallets(Wallet wallet) {
            this.wallets.add(wallet);
        }

        public void setTransaction(Transaction transaction) {
            this.transactions.add(transaction);
        }


        /*method to send and receive cryptos
        amount is passed as a negative number for sending crypto and as a positive number for receiving*/
        public String tradeCryto(String walletName, String Cryptoname, Double amount, String type) {
            getOneWallet(walletName).setCryptos(Cryptoname, amount);
            Transaction newTransaction = new Transaction("approved", Cryptoname, amount, type);
            setTransaction(newTransaction);
            return newTransaction.toString();
        }


        //check if the name of the wallet corresponds to an existing one
        public Boolean checkNameExist(String walletName) {
            for (int i = 0; i < this.wallets.size(); i++) {
                if (this.wallets.get(i).getWalletName().equals(walletName)) {
                    return true;
                }
            }
            return false;
        }


        @Override
        public String toString() {
            return "Investor{" +
                    "userName='" + userName + '\'' +
                    ", password='" + password + '\'' +
                    ", wallets=" + wallets +
                    ", recoveryPhrase='" + recoveryPhrase + '\'' +
                    ", transactions=" + transactions +
                    ", firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    '}';
        }
    }

