import {Floorsstatus} from './floorsstatus';
import {Floorstype} from './floorstype';

export interface Floors {
  floorId: number;
  floorCode: string;
  floorName: string;
  floorArea: number;
  floorCapacity: number;
  floorDeleteFlag: number;
  floorsStatus: Floorsstatus;
  floorsType: Floorstype;
}
