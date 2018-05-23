package model.blockchain.rawaddress;

import com.google.gson.annotations.SerializedName;
import model.blockchain.RawInputs;
import model.blockchain.RawOut;

import java.util.List;

public class RawAddressTransactions {
    @SerializedName("ver")
    private Integer ver;

    @SerializedName("inputs")
    private List<RawInputs> inputs;

    @SerializedName("weight")
    private Long weight;

    @SerializedName("block_height")
    private Long blockHeight;

    @SerializedName("relayed_by")
    private String relayedBy;

    @SerializedName("out")
    private List<RawOut> out;

    @SerializedName("lock_time")
    private Long lockTime;

    @SerializedName("result")
    private String result;

    @SerializedName("size")
    private Long size;

    @SerializedName("time")
    private Long time;

    @SerializedName("tx_index")
    private Long transactionIndex;

    @SerializedName("vin_sz")
    private Long vinSz;

    @SerializedName("hash")
    private String hash;

    @SerializedName("vout_sz")
    private Long voutSz;

    public Integer getVer() {
        return ver;
    }

    public void setVer(Integer ver) {
        this.ver = ver;
    }

    public List<RawInputs> getInputs() {
        return inputs;
    }

    public void setInputs(List<RawInputs> inputs) {
        this.inputs = inputs;
    }

    public Long getWeight() {
        return weight;
    }

    public void setWeight(Long weight) {
        this.weight = weight;
    }

    public Long getBlockHeight() {
        return blockHeight;
    }

    public void setBlockHeight(Long blockHeight) {
        this.blockHeight = blockHeight;
    }

    public String getRelayedBy() {
        return relayedBy;
    }

    public void setRelayedBy(String relayedBy) {
        this.relayedBy = relayedBy;
    }

    public List<RawOut> getOut() {
        return out;
    }

    public void setOut(List<RawOut> out) {
        this.out = out;
    }

    public Long getLockTime() {
        return lockTime;
    }

    public void setLockTime(Long lockTime) {
        this.lockTime = lockTime;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Long getTransactionIndex() {
        return transactionIndex;
    }

    public void setTransactionIndex(Long transactionIndex) {
        this.transactionIndex = transactionIndex;
    }

    public Long getVinSz() {
        return vinSz;
    }

    public void setVinSz(Long vinSz) {
        this.vinSz = vinSz;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public Long getVoutSz() {
        return voutSz;
    }

    public void setVoutSz(Long voutSz) {
        this.voutSz = voutSz;
    }
}
