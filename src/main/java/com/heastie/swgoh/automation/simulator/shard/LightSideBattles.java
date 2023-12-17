package com.heastie.swgoh.automation.simulator.shard;

import com.heastie.swgoh.automation.bean.Shard;
import com.heastie.swgoh.automation.bean.ShardType;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class LightSideBattles {
    private final ShardBattlesScript shardBattlesScript;

    public LightSideBattles(final ShardBattlesScript shardBattlesScript) {
        this.shardBattlesScript = shardBattlesScript;
    }

    public void automate(final List<Shard> shards) {
        shardBattlesScript.goToLightSideBattlesTable();
        shardBattlesScript.simulateShardNodes(shards, ShardType.CHARACTER);
        shardBattlesScript.goToHome();
    }
}
