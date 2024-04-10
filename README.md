# Easy NPC: Epic-Fight Integration

[![Easy NPC - Epic Fight Downloads](http://cf.way2muchnoise.eu/full_957625_downloads.svg)](https://www.curseforge.com/minecraft/mc-mods/easy-npc-epic-fight)
[![Easy NPC - Epic Fight Versions](http://cf.way2muchnoise.eu/versions/Minecraft_957625_all.svg)](https://www.curseforge.com/minecraft/mc-mods/easy-npc-epic-fight)

This mod adds integration for [Easy NPC][easy_npc] and the [Epic Fight][epic_fight] mods.

Unlock a new dimension of interaction within your Minecraft world by combining the user-friendly
Easy NPCs mod with the immersive combat mechanics of Epic Fight. This integration mod introduces a
simple yet robust system that empowers you to effortlessly integrate Epic Fight's complex game
mechanics and fighting styles into your custom NPCs.

Now, not only can you craft unique characters with Easy NPCs, complete with captivating dialogues,
but you can also tailor their combat behaviors using the diverse fighting styles provided by Epic
Fight. Whether you want your NPCs to wield specific weapons, execute special moves, or showcase
distinct combat strategies, the Easy NPCs - Epic Fight Integration mod opens up a world of
possibilities.

Immerse yourself in epic battles and intricate storytelling as your Easy NPCs become formidable
warriors with the addition of Epic Fight's advanced combat features. Unleash creativity, design
compelling narratives, and watch as your custom NPCs evolve into memorable characters that add depth
and excitement to your Minecraft adventures.

## Restrictions

There are some restrictions for the integration because of the unique custom models of the Epic
Fight mod.

The Pose configuration is not supported for the Epic Fight models, and the NPC will always use the
Epic Fight pose.

Scaling is also not supported because of the unique model size of the Epic Fight mod.

Most of the other configuration options are supported and can be used with the Epic Fight models.

Further more not all models are supported out of the box.

### Animation and Custom Weapons

Please check the [Epic Fight Mod documentation][epic_fight_wiki] for more information about the
Epic Fight Mod and how to add custom animations and support for additional weapons over data packs.

This mod is only an integration mod and does not provide a full animation set for the Epic Fight
mod and custom weapons and use-cases.

You can check the existing example NPC configuration used by this integration mod
under `/Forge/src/main/resources/data.easy_npc_epic_fight/epicfight_mobpatch/`.

## Requirements

| Version | [Easy NPC Mod][easy_npc] | [Epic Fight Mod][epic_fight] |
|---------|--------------------------|------------------------------|
| 1.0.0   | 1.x                      | 18.5.19                      |
| 3.0.0   | > 3.7.2 and < 4.x        | 18.5.19                      |
| 4.0.0   | > 4.3.3 and < 5.x        | 18.5.24                      |

## Documentation

### Easy NPC

Please check the [Easy NPC Mod][easy_npc_wiki] wiki for more information about the Easy NPC Mod.

### Epic Fight

Please check the [Epic Fight Mod][epic_fight_wiki] wiki for more information about the Epic Fight
Mod.

[easy_npc]: https://www.curseforge.com/minecraft/mc-mods/easy-npc

[easy_npc_wiki]: https://github.com/MarkusBordihn/BOs-Easy-NPC/wiki

[epic_fight]: https://www.curseforge.com/minecraft/mc-mods/epic-fight-mod

[epic_fight_wiki]: https://epicfight-docs.readthedocs.io/Guides/page1/
