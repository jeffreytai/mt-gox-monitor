package model;

public class AddressData {

    private String address;
    private Double received;
    private Double balance;
    private Long tx_count;
    private Long unconfirmed_tx_count;
    private Long unconfirmed_received;
    private Long unconfirmed_sent;
    private Long unspent_tx_count;
    private String first_tx;
    private String last_tx;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getReceived() {
        return received;
    }

    public void setReceived(Double received) {
        this.received = received;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Long getTx_count() {
        return tx_count;
    }

    public void setTx_count(Long tx_count) {
        this.tx_count = tx_count;
    }

    public Long getUnconfirmed_tx_count() {
        return unconfirmed_tx_count;
    }

    public void setUnconfirmed_tx_count(Long unconfirmed_tx_count) {
        this.unconfirmed_tx_count = unconfirmed_tx_count;
    }

    public Long getUnconfirmed_received() {
        return unconfirmed_received;
    }

    public void setUnconfirmed_received(Long unconfirmed_received) {
        this.unconfirmed_received = unconfirmed_received;
    }

    public Long getUnconfirmed_sent() {
        return unconfirmed_sent;
    }

    public void setUnconfirmed_sent(Long unconfirmed_sent) {
        this.unconfirmed_sent = unconfirmed_sent;
    }

    public Long getUnspent_tx_count() {
        return unspent_tx_count;
    }

    public void setUnspent_tx_count(Long unspent_tx_count) {
        this.unspent_tx_count = unspent_tx_count;
    }

    public String getFirst_tx() {
        return first_tx;
    }

    public void setFirst_tx(String first_tx) {
        this.first_tx = first_tx;
    }

    public String getLast_tx() {
        return last_tx;
    }

    public void setLast_tx(String last_tx) {
        this.last_tx = last_tx;
    }
}
