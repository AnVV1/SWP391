import {Customer} from '../customer/customer';
import { Employee } from '../employee/employee';
import {Spaces} from '../space/spaces';


export interface Contract {
  contractId ?: number;
  contractCode ?: string;
  contractExpired ?: string;
  contractDateStart ?: string;
  contractDateEnd ?: string;
  contractTotal ?: string;
  contractContent ?: string;
  contractDeposit?: number;
  contractDeleteFlag ?: boolean;
  checkFlag ?: number;
  contractImageUrl?: string;
  customer ?: Customer;
  employee ?: Employee;
  spaces ?: number;
}
