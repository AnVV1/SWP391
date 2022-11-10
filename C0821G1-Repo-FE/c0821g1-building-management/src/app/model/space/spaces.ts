import {SpacesType} from './spaces-type';
import {SpacesStatus} from './spaces-status';
import {Floors} from '../floors/floors';
export interface Spaces {
  spaceId: number;
  spaceCode: string;
  spaceArea: string;
  spacePrice: string;
  spaceManagerFee: string;
  spaceNote: string;
  spaceImage: string;
  spaceDeleteFlag: string;
  spacesType: SpacesType;
  spaceStatus: SpacesStatus;
  floors: Floors;
}
