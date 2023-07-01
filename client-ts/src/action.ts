export class MoveAction implements Action {
  private readonly posX: number;
  private readonly posY: number;

  constructor(posX:number, posY:number) {
    this.posX = posX;
    this.posY = posY;
    this.type = "move"
  }
  toJSON(): string {
    return `{"posX":${this.posX},"posY":${this.posY},"type":"${this.type}"}`;
  }

  type: string;

}

export class HarvestAction implements Action {
  private readonly stationId: number;

  constructor(stationId:number) {
    this.type = "harvest";
    this.stationId = stationId;
  }
  toJSON(): string {
    return `{"stationId":${this.stationId},"type":"${this.type}"}`;
  }

  type: string;
}

export class SellAction implements Action {
  type: string = "sell";

  toJSON(): string {
    return `{"type":"${this.type}"}`;
  }
}

export class EndAction implements Action {
  type: string = "end";

  toJSON(): string {
    return `{"type":"${this.type}"}`;
  }

}

export default interface Action {
  type: string
  toJSON(): string
}