package model.blockchain;

import com.google.gson.annotations.SerializedName;
import model.blockchain.rawaddress.RawAddressPrevOut;

public class RawInputs {
    @SerializedName("sequence")
    private String sequence;

    @SerializedName("witness")
    private String witness;

    @SerializedName("prev_out")
    private RawAddressPrevOut previousOut;

    @SerializedName("script")
    private String script;

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

    public String getWitness() {
        return witness;
    }

    public void setWitness(String witness) {
        this.witness = witness;
    }

    public RawAddressPrevOut getPreviousOut() {
        return previousOut;
    }

    public void setPreviousOut(RawAddressPrevOut previousOut) {
        this.previousOut = previousOut;
    }

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
    }
}
