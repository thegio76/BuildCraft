package buildcraft.robotics;

import io.netty.buffer.ByteBuf;
import net.minecraft.util.math.ChunkPos;

public class ZonePlannerMapChunkKey {
    public static final int LEVEL_HEIGHT = 32;

    public ChunkPos chunkPos = null;
    public int dimensionalId = 0;
    public int level = 0;

    public ZonePlannerMapChunkKey() {
    }

    public ZonePlannerMapChunkKey(ChunkPos chunkPos, int dimensionalId, int level) {
        this.chunkPos = chunkPos;
        this.dimensionalId = dimensionalId;
        this.level = level;
    }

    public void fromBytes(ByteBuf buf) {
        chunkPos = new ChunkPos(buf.readInt(), buf.readInt());
        dimensionalId = buf.readInt();
        level = buf.readInt();
    }

    public void toBytes(ByteBuf buf) {
        buf.writeInt(chunkPos.chunkXPos);
        buf.writeInt(chunkPos.chunkZPos);
        buf.writeInt(dimensionalId);
        buf.writeInt(level);
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) {
            return true;
        }
        if(o == null || getClass() != o.getClass()) {
            return false;
        }

        ZonePlannerMapChunkKey that = (ZonePlannerMapChunkKey) o;

        if(dimensionalId != that.dimensionalId) {
            return false;
        }
        if(level != that.level) {
            return false;
        }
        return chunkPos.equals(that.chunkPos);

    }

    @Override
    public int hashCode() {
        int result = chunkPos.hashCode();
        result = 31 * result + dimensionalId;
        result = 31 * result + level;
        return result;
    }
}
