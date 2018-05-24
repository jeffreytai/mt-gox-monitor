package model.blockchain.block;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BlockHeight {
    @SerializedName("blocks")
    private List<Block> blocks;

    public List<Block> getBlocks() {
        return blocks;
    }

    public void setBlocks(List<Block> blocks) {
        this.blocks = blocks;
    }
}
