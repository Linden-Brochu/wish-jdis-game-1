# Client python

## What is what?

### action.py

All available actions are written here.
NEVER SEND THE BASE ACTION. THE SERVER WILL CRASH REALLY HARD.

#### move_action

Send this to move somewhere

```py
import action
...
return action.move_action(x, y)
```

#### harvest_action

Send this to harvest a station.
Must be on the station to harvest.

```py
import action
...
return action.harvest_action(id)
```

#### sell_action

Send this to sell the payload.
Must be at (0,0).

```py
import action
...
return action.sell_action
```

#### end_action

Send this to end the simulation.

```py
import action
...
return action.end_action()
```

### simulation.py

All available models.

#### simulation

Parent simulation

#### player

Player model. Contains the player position, payload and money.

#### station

Station model. Contains the station position, last harvest and id.

### bot.py

The code to run the bot. Must be named `custom_bot` and must have
a method named `run(self, sim)` where `sim` is an object of
`simulation.simulation`. The programmer can add any field, method
and class as desired.

### main.py

DO NOT CHANGE. Entry point of the client.

## How to code

Get gud. Code