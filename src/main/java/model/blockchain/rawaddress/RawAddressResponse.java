package model.blockchain.rawaddress;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RawAddressResponse {

    @SerializedName("hash160")
    private String hash160;

    @SerializedName("address")
    private String address;

    @SerializedName("n_tx")
    private Integer numberTransaction;

    @SerializedName("total_received")
    private Long totalReceived;

    @SerializedName("total_sent")
    private Long totalSent;

    @SerializedName("final_balance")
    private Long finalBalance;

    @SerializedName("txs")
    private List<RawAddressTransactions> transactions;

    public String getHash160() {
        return hash160;
    }

    public void setHash160(String hash160) {
        this.hash160 = hash160;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getNumberTransaction() {
        return numberTransaction;
    }

    public void setNumberTransaction(Integer numberTransaction) {
        this.numberTransaction = numberTransaction;
    }

    public Long getTotalReceived() {
        return totalReceived;
    }

    public void setTotalReceived(Long totalReceived) {
        this.totalReceived = totalReceived;
    }

    public Long getTotalSent() {
        return totalSent;
    }

    public void setTotalSent(Long totalSent) {
        this.totalSent = totalSent;
    }

    public Long getFinalBalance() {
        return finalBalance;
    }

    public void setFinalBalance(Long finalBalance) {
        this.finalBalance = finalBalance;
    }

    public List<RawAddressTransactions> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<RawAddressTransactions> transactions) {
        this.transactions = transactions;
    }
}
