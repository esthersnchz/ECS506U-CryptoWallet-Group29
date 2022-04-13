package TransferCrypto;

import java.util.HashMap;

public class Wallet {
    private String walletName;
    private String PrivateKey;
    private String  PublicKey;
    private String walletAddress ;
    private boolean inheritance;
    private HashMap<String, Double> Cryptos;

    Wallet(String walletName,String Pikey, String Pukey, String address, boolean inherit ){
        this.walletName=walletName;
        this.PrivateKey= Pikey;
        this.PublicKey = Pukey;
        this.walletAddress = address;
        this.inheritance = inherit;
        this.Cryptos = new HashMap<String, Double>();
    }

    //getters
    public String getWalletName(){return walletName;}
    public  String  getPrivateKey(){return PrivateKey;}
    public String   getPublicKey(){return PublicKey;}
    public String getwalletAddress(){return walletAddress;}
    public boolean getinheritance(){return inheritance;}
    public HashMap getCryptos(){return Cryptos;}

    //setters
    public void setPrivateKey(String key){ this.PrivateKey= key;}
    public void setPublicKey(String key){this.PublicKey =key;}
    public void setwalletAddress(String address){this.walletAddress= address;}
    public void setinheritance(boolean inheritance){this.inheritance= inheritance;}

    public void setCryptos(String name, Double amount){
        if (Cryptos.isEmpty()){Cryptos.put(name,amount);}
        else if (Cryptos.computeIfPresent(name, (k, val) -> val + amount ) == null){
            Cryptos.put(name,amount);
        }
    }
    public boolean checkCryptoExists(String cryptoName){
        if (this.Cryptos.containsKey(cryptoName)){return true;}
        return false;
    }

    public boolean checkFunds(String cryptoName, double amount){
        if ( this.Cryptos.get(cryptoName)< amount){
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Wallet{" +
                "PrivateKey='" + PrivateKey + '\'' +
                ", PublicKey='" + PublicKey + '\'' +
                ", walletAddress='" + walletAddress + '\'' +
                ", inheritance=" + inheritance +
                ", Cryptos=" + Cryptos +
                '}';
    }
}
