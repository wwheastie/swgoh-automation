package com.heastie.swgoh.automation.simulator.shard;

import com.heastie.swgoh.automation.bean.Shard;
import com.heastie.swgoh.automation.bean.ShardType;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class DarkSideBattles {
    private final ShardBattlesScript shardBattlesScript;

    public DarkSideBattles(final ShardBattlesScript shardBattlesScript) {
        this.shardBattlesScript = shardBattlesScript;
    }

    public void automate(final List<Shard> shards) {
        shardBattlesScript.goToDarkSideBattlesTable();
        shardBattlesScript.simulateShardNodes(shards, ShardType.CHARACTER);
        shardBattlesScript.goToHome();
    }
}
