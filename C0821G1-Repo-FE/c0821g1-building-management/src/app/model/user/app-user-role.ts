import {AppUser} from './app-user';
import {Role} from './role';

export interface AppUserRole {
  appUserRoleId: number;
  appUser: AppUser;
  role: Role;
}
