import Simulation from "./simulation.js";
import Action, {EndAction, HarvestAction, MoveAction, SellAction} from "./action.js";

class CustomBot {
  run(simulation: Simulation): Action|null {
    console.log(simulation);
    return null;
  }

}

export default CustomBot;