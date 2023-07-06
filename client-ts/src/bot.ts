import Simulation, { Player, Station } from "./simulation.js";
import Action, {EndAction, HarvestAction, MoveAction, SellAction} from "./action.js";

class CustomBot {
  numberOfHarvest: number = 0;
  stationId: number = 0;

  run(simulation: Simulation): Action|null {
    console.log(simulation);
    const player: Player = simulation.player;
    let station: Station = simulation.stations[this.stationId];

    if (station.lastHarvested < 20) {
      this.stationId++;
      if (this.stationId == 10) {
        return new EndAction();
      }

      station = simulation.stations[this.stationId];
    }

    if (player.payload == 0) {
      if (player.posX == station.posX && player.posY == station.posY) {
        this.numberOfHarvest = 1;
        return new HarvestAction(this.stationId);
      }
      return new MoveAction(station.posX, station.posY);
    }

    if (this.numberOfHarvest == 3) {
      if (player.posX == 0 && player.posY == 0) {
        return new SellAction();
      }
      return new MoveAction(0,0);
    }

    this.numberOfHarvest++;
    return new HarvestAction(this.stationId);
  }

}

export default CustomBot;