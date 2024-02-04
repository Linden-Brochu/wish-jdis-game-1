# Client typescript

- Run `npm install` to install dependancies.
- Run `npm run serve` to start the client

## What is what?

### action.ts

All available actions are written here.
NEVER SEND ANOTHER ACTION THAN THOSE ALREADY CODED.
THE SERVER WILL CRASH REALLY HARD.

#### MoveAction

Send this to move somewhere

```ts
import {MoveAction} from './action.js';
...
return new MoveAction(x,y);
```

#### HarvestAction

Send this to harvest a station.
Must be on the station to harvest.

```ts
import {HarvestAction} from './action.js';
...
return new HarvestAction(id);
```

#### SellAction

Send this to sell the payload.
Must be at (0,0).

```ts
import {SellAction} from './action.js';
...
return new SellAction();
```

#### EndAction

Send this to end the simulation.

```ts
import {EndAction} from './action.js';
...
return new EndAction();
```

### simulation.ts

All available models.

#### Simulation

Parent simulation

#### Player

Player model. Contains the player position, payload and money.

#### Station

Station model. Contains the station position, last harvest and id.

### bot.ts

The code to run the bot. Must be named `CustomBot` and must have
a method named `run(simulation: Simulation)` where `simulation`
is an object of `Simulation`. The programmer can add any field,
method and class as desired.

### main.ts

DO NOT CHANGE. Entry point of the client.

## How to code

Get gud. Code
