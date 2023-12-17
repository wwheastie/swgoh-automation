package com.heastie.swgoh.automation.simulator.shard;

import com.heastie.swgoh.automation.bean.Shard;
import com.heastie.swgoh.automation.bean.ShardType;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class FleetBattles {
    private final ShardBattlesScript shardBattlesScript;

    public FleetBattles(final ShardBattlesScript shardBattlesScript) {
        this.shardBattlesScript = shardBattlesScript;
    }

    public void automate(final List<Shard> shards) {
        shardBattlesScript.goToFleetBattlesTable();
        shardBattlesScript.simulateShardNodes(shards, ShardType.SHIP);
        shardBattlesScript.goToHomeFromFleet();
    }
}
