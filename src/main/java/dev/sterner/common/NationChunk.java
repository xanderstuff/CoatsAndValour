package dev.sterner.common;

import java.util.Optional;

@Deprecated
public interface NationChunk {

    Optional<Nation> getNation();

    void setNation(Nation nation);
}
