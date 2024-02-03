import { ComponentFixture, TestBed } from '@angular/core/testing';
import { LoginComponent } from './login.component';
import { MdbModalRef, MdbModalService } from 'mdb-angular-ui-kit/modal';
import { ApiService } from 'src/app/services/api.service';
import { AuthService } from 'src/app/services/auth.service';
import { FormBuilder, ReactiveFormsModule } from '@angular/forms';
import { of } from 'rxjs';
import { ForgetpasswordComponent } from '../forgetpassword/forgetpassword.component';

describe('LoginComponent', () => {
  let component: LoginComponent;
  let fixture: ComponentFixture<LoginComponent>;
  let mockModalRef: Partial<MdbModalRef<LoginComponent>>;
  let mockModalService: Partial<MdbModalService>;
  let mockApiService: jasmine.SpyObj<ApiService>;
  let mockAuthService: jasmine.SpyObj<AuthService>;

  beforeEach(() => {
    mockModalRef = {
      close: jasmine.createSpy('close'),
    };

    mockModalService = {
      open: jasmine.createSpy('open'),
    };

    mockApiService = jasmine.createSpyObj('ApiService', ['registerUser', 'loginUser']);
    mockAuthService = jasmine.createSpyObj('AuthService', ['login']);

    TestBed.configureTestingModule({
      declarations: [LoginComponent],
      imports: [ReactiveFormsModule], // Import the ReactiveFormsModule
      providers: [
        { provide: MdbModalRef, useValue: mockModalRef },
        { provide: MdbModalService, useValue: mockModalService },
        { provide: ApiService, useValue: mockApiService },
        { provide: AuthService, useValue: mockAuthService },
        FormBuilder, // Include the FormBuilder
      ],
    });

    fixture = TestBed.createComponent(LoginComponent);
    component = fixture.componentInstance;
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should open modal', () => {
    component.openModal();
    expect(mockModalService.open).toHaveBeenCalledWith(ForgetpasswordComponent, {
      modalClass: 'modal-dialog-centered',
    });
  });

  // Add more test cases for register, login, revert_login, and revert_register functions.
});

