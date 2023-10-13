## Items
- simple intermediate crafting items
  - [ ] Bayonet
  - [ ] Stock
  - [ ] Grip
  - [ ] Long Barrel
  - [ ] Short Barrel
  - [ ] Thick Barrel
  - [ ] Ramrod
  - [ ] Flintlock Mechanism
  - [ ] Cylinder
  - [ ] Percussion Mechanism
  - [ ] Bolt
  - [ ] Spring 

- weapons
  - [ ] Field Cannon (simple item to spawn it, akin to spawn egg but not a spawn egg) (see #entities - Field Cannon)
  - swords
    - [ ] Cutlass
    - [ ] Sabre
  - guns
    - [ ] Musket
    - [ ] Blunderbuss
    - [ ] Pistol

- ammo
  - [ ] Shot
  - [ ] Silver Shot
    - [ ] Silver Ingot (would this be from another mod? or how should silver be added?)
  - [ ] Roundshot
  - [ ] Caseshot
  - [ ] Shellshot

- other weapon-related items
  - [ ] Powder Charge
  - [ ] Block Rammer
  - [ ] Sponge

- other items to be used by players 
  - [ ] Bandages
  - [ ] Bone Saw
  - [ ] Nation Uniform: Hat (see #mechanics - customizable nation uniforms)
  - [ ] Nation Uniform: Coat (see #mechanics - customizable nation uniforms)
  - [ ] Nation Uniform: Breeches (see #mechanics - customizable nation uniforms)
  - [ ] Nation Uniform: Boots (see #mechanics - customizable nation uniforms)

## Entities
- [ ] Field Cannon
  - animations
    - [ ] loading 1 (add powder charge?)
    - [ ] loading 2 (add ammo)
    - [ ] loading 3 (use block rammer?)
    - [ ] loading 4 (use ???)
    - [ ] (my idea) fuse lit countdown (when complete, trigger firing)
    - [ ] firing (probably don't handle smoke particles here. Handle it when firing a projectile)
    - [ ] cleaning (use Sponge)
    - [ ] ~~self-destruct explosion~~ (may not need an animation for this, perhaps just use normal explosion particles)
  - [ ] load state <store which items are currently loaded>
    - [ ] if loaded, a little fuse rope texture appears
  - [ ] able to fire projectiles (depends on what type of ammo is currently loaded)
  - [ ] use flint+steel to fire if loaded
  - [ ] able to be mounted by Players, use WASD to move (slowly...)
    - [ ] override the typical strafing of A/D keys with left/right rotation instead (remember: movement is clientside)
  - [ ] self-destruct chance (residue explosives build up after each use, but can be cleaned with Sponge, see tnt explosion)
  - [ ] can be leaded to horses, camels, or boats

## Mechanics
- [ ] bleeding
  - [ ] slowly loose health over time
  - [x] status effect icon
  - [ ] force disable particles
  - [ ] custom blood dripping particle
  - [x] add gangrene after some time
  - [ ] (fix) missing status effect translation string
  - [ ] (fix) don't spam component update packets
- [ ] gangrene
  - [x] increases level over time
  - [x] status effect icon
  - [x] health bar icon overlay
  - [ ] (fix) missing status effect translation string
  - [ ] (fix) don't spam component update packets
- [ ] customizable nation uniforms
  - [ ] Textile Block
    - [ ] interactable block (see `CraftingTableBlock`)
    - [ ] GUI (perhaps use OwO-lib?)
      - [ ] player preview (same as player inventory)
      - [ ] input and output nation uniform item slot
      - [ ] style selector
      - [ ] primary, secondary, and tertiary dye color inputs
      - [ ] additional customization controls
  - [ ] Nation Uniforms have different main styles (stored in NBT. Probably an Enum)
  - [ ] Nation Uniforms can be dyed (stored in NBT, see leather armour)
    - [ ] the texture used to render this armour is colored in some sections, but not others (see leather armour)

## Mod Integration
- Better Combat
  - [ ] Cutlass, Pistol swords, Sabres use the cutlass preset
- Mod Menu
  - [ ] add proper mod icon

## Configurables
- [ ] add config library, save/load, server authoritative (sync with clients). Does OwO-lib have a server-controlled config api?
- Options for each weapon: (use a hierarchical config, perhaps json/json5/toml)
  - [ ] Damage <damage units>
  - [ ] Half-Cock Stage Time <ticks>
  - [ ] Primed Stage Time <ticks>
  - [ ] Reload Stage Time <ticks>
  - [ ] Full-Cock Stage Time <ticks>
  - [ ] Disabled <boolean, default false>
- Options for bleeding mechanic:
  - [ ] Ticks Per Damage <ticks, default 10>
  - [ ] Damage <damage units, default 1>
- Options for gangrene mechanic:
  - [ ] Time Until Infection <ticks, default 1200>
  - [ ] Ticks Per Infection <ticks, default 1200>
  - [ ] Infection Amount <damage units, default 1>
