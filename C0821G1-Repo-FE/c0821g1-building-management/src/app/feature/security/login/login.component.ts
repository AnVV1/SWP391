import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {TokenStorageService} from '../../../service/security/token-storage.service';
import {Router} from '@angular/router';
import {SecurityService} from '../../../service/security/security.service';
import {ShareService} from '../../../service/security/share.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginFrom: FormGroup;
  username: string;
  roles: string[] = [];
  errorMessage = '';
  isLoggedIn: boolean;
  urlImg: string;
  role: string;
  idEmployee: any;

  constructor(private fb: FormBuilder,
              private tokenStorageService: TokenStorageService,
              private securityService: SecurityService,
              private router: Router,
              private shareService: ShareService) {
  }

  ngOnInit(): void {
    this.loginFrom = this.fb.group({
      username: ['', Validators.required],
      password: ['', Validators.required],
      remember_me: false
    });
    if (this.tokenStorageService.getUser()) {
      this.securityService.isLoggedIn = true;
      this.role = this.tokenStorageService.getUser().roles[0];
      this.username = this.tokenStorageService.getUser().username;
      this.router.navigate(['']);

    }
  }

  onSubmit() {
    this.securityService.login(this.loginFrom.value).subscribe(data => {
        console.log(data);
        if (this.loginFrom.value.remember_me === true) {
          this.tokenStorageService.saveUserLocal(data);
          this.tokenStorageService.saveTokenLocal(data.jwtToken);
        } else if (this.loginFrom.value.remember_me === false) {
          this.tokenStorageService.saveUserSession(data);
          this.tokenStorageService.saveTokenSession(data.jwtToken);
          // this.username = this.loginFrom.controls.username.value;
        }
        this.isLoggedIn = true;
        this.username = this.tokenStorageService.getUser().username;
        this.role = this.tokenStorageService.getUser().roles[0];
        console.log('username: ' + this.tokenStorageService.getUser().username);
        console.log('role: ' + this.tokenStorageService.getUser().roles);
        console.log('token: ' + this.tokenStorageService.getUser().jwtToken);

        this.loginFrom.reset();
        if (this.role.indexOf('ROLE_ADMIN') !== -1) {
          this.router.navigate(['/employee/list']);
          this.shareService.sendClickEvent();

        } else {
          this.router.navigate(['/customer/list']);
          this.shareService.sendClickEvent();

        }
      }
      , error => {
        console.log(error);
        this.isLoggedIn = false;
        this.errorMessage = 'Tài khoản hoặc mật khẩu không đúng';
      });
  }

  private loadRemberInfo() {
    if (this.tokenStorageService.getUser()) {
      this.role = this.tokenStorageService.getUser().roles[0];
      console.log(this.role);
      this.username = this.tokenStorageService.getUser().username;
      console.log(this.username);
      this.urlImg = this.tokenStorageService.getUser().urlImg;
    } else {
      this.role = null;
      this.username = null;
      this.urlImg = null;
      this.idEmployee = null;
    }
    this.isLoggedIn = this.username != null;
  }
}
