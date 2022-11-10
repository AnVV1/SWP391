

export interface ContractDto {
  contractId: number;
  contractCode: string;
  contractExpired: string;
  contractDateStart: string;
  contractDateEnd: string;
  price: number;
  contractDeposit: number;
  contractTaxCode: string;
  contractImageUrl: string;
  contractTotal: string;
  contractContent: string;
  employeeId: number;
  customerId: number;
  spaceId: number;
  contractDeleteFlag: false;
  checkFlag: number;
}
