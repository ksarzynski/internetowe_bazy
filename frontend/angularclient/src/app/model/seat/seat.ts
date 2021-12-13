import { hall } from "../hall/hall";

export class seat {
    seatId: number;
    isPremium: boolean;
    myColumnNumber: number;
    myRowNumber: number;
    seatFee: number;
    
    constructor() {
      this.seatId = 0;
      this.isPremium = false;
      this.myColumnNumber = 0;
      this.myRowNumber = 0;
      this.seatFee = 0;
    }
  }
  