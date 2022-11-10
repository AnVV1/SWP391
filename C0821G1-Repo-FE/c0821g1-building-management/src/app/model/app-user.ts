import {Roles} from './roles';

export interface AppUser {
  appUserId: number;
  appUserName: string;
  appUserPass: string;
  roles: Roles;
}
