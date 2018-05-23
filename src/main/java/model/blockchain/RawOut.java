package model.blockchain;

import com.google.gson.annotations.SerializedName;

public class RawOut {
    @SerializedName("spent")
    private boolean spent;

    @SerializedName("tx_index")
    private Long transactionIndex;

    @SerializedName("type")
    private Integer type;

    @SerializedName("addr")
    private String address;

    @SerializedName("value")
    private Double value;

    @SerializedName("n")
    private Integer n;

    @SerializedName("script")
    private String script;

    public boolean isSpent() {
        return spent;
    }

    public void setSpent(boolean spent) {
        this.spent = spent;
    }

    public Long getTransactionIndex() {
        return transactionIndex;
    }

    public void setTransactionIndex(Long transactionIndex) {
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

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Integer getN() {
        return n;
    }

    public void setN(Integer n) {
        this.n = n;
    }

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
    }
}
