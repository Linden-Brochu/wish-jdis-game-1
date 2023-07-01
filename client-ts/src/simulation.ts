interface Player {
  posX: number
  posY: number
  payload: number
  money: number
}

interface Station {
  posX: number
  posY: number
  lastHarvested: number
  id: number
}

interface Simulation {
  player: Player,
  stations: Station[]
}

export default Simulation;