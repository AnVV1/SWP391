import {EmployeePosition} from './employee-position';
import {AppUser} from '../app-user';

export interface Employee {
  employeeId: number;
  employeeCode: string;
  employeeAddress: string;
  employeeDateOfBirth: string;
  employeeDeleteFlag: boolean;
  employeeEmail: string;
  employeeGender: string;
  employeeImage: string;
  employeeName: string;
  employeePhone: string;
  employeeStartDate: string;
  employeePosition: EmployeePosition;
  appUser: AppUser;
}
