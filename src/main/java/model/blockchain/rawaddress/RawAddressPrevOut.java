package model.blockchain.rawaddress;

import com.google.gson.annotations.SerializedName;

public class RawAddressPrevOut {
    @SerializedName("spent")
    private boolean spent;

    @SerializedName("tx_index")
    private String transactionIndex;

    @SerializedName("type")
    private Integer type;

    @SerializedName("addr")
    private String address;

    @SerializedName("value")
    private Long value;

    @SerializedName("n")
    private Long n;

    @SerializedName("script")
    private String script;

    public boolean isSpent() {
        return spent;
    }

    public void setSpent(boolean spent) {
        this.spent = spent;
    }

    public String getTransactionIndex() {
        return transactionIndex;
    }

    public void setTransactionIndex(String transactionIndex) {
        this.transactionIndex = transactionIndex;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public Long getN() {
        return n;
    }

    public void setN(Long n) {
        this.n = n;
    }

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
    }
}
