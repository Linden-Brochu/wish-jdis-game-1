import Simulation from "./simulation.js";
import Action, {EndAction, HarvestAction, MoveAction, SellAction} from "./action.js";

class CustomBot {
  run(simulation: Simulation): Action|null {
    console.log(simulation);
    // return null to do the same action as last iteration
    return null;
  }

}

export default CustomBot;