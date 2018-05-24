package model.blockchain.block;

import com.google.gson.annotations.SerializedName;

public class Block {

    @SerializedName("hash")
    private String hash;

    @SerializedName("ver")
    private String version;

    @SerializedName("prev_block")
    private String previousBlock;

    @SerializedName("mrkl_root")
    private String merkleRoot;

    @SerializedName("time")
    private Long time;

    @SerializedName("bits")
    private Long bits;

    @SerializedName("fee")
    private Long fee;

    @SerializedName("none")
    private String nonce;

    @SerializedName("n_tx")
    private Long numberTransactions;

    @SerializedName("size")
    private Long size;

    @SerializedName("block_index")
    private Long blockIndex;

    @SerializedName("main_chain")
    private boolean mainChain;

    @SerializedName("height")
    private Long height;

    @SerializedName("received_time")
    private Long receivedTime;

    @SerializedName("relayed_by")
    private String relayedBy;

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getPreviousBlock() {
        return previousBlock;
    }

    public void setPreviousBlock(String previousBlock) {
        this.previousBlock = previousBlock;
    }

    public String getMerkleRoot() {
        return merkleRoot;
    }

    public void setMerkleRoot(String merkleRoot) {
        this.merkleRoot = merkleRoot;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Long getBits() {
        return bits;
    }

    public void setBits(Long bits) {
        this.bits = bits;
    }

    public Long getFee() {
        return fee;
    }

    public void setFee(Long fee) {
        this.fee = fee;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public Long getNumberTransactions() {
        return numberTransactions;
    }

    public void setNumberTransactions(Long numberTransactions) {
        this.numberTransactions = numberTransactions;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public Long getBlockIndex() {
        return blockIndex;
    }

    public void setBlockIndex(Long blockIndex) {
        this.blockIndex = blockIndex;
    }

    public boolean isMainChain() {
        return mainChain;
    }

    public void setMainChain(boolean mainChain) {
        this.mainChain = mainChain;
    }

    public Long getHeight() {
        return height;
    }

    public void setHeight(Long height) {
        this.height = height;
    }

    public Long getReceivedTime() {
        return receivedTime;
    }

    public void setReceivedTime(Long receivedTime) {
        this.receivedTime = receivedTime;
    }

    public String getRelayedBy() {
        return relayedBy;
    }

    public void setRelayedBy(String relayedBy) {
        this.relayedBy = relayedBy;
    }
}
