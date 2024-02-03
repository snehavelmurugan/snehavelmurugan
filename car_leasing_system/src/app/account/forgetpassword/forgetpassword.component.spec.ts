import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ForgetpasswordComponent } from './forgetpassword.component';
import { MdbModalRef } from 'mdb-angular-ui-kit/modal';
import { EmailService } from 'src/app/services/email.service';
import { of } from 'rxjs';

describe('ForgetpasswordComponent', () => {
  let component: ForgetpasswordComponent;
  let fixture: ComponentFixture<ForgetpasswordComponent>;
  let mockModalRef: Partial<MdbModalRef<ForgetpasswordComponent>>;
  let mockEmailService: jasmine.SpyObj<EmailService>;

  beforeEach(() => {
    mockModalRef = {
      close: jasmine.createSpy('close'),
    };

    mockEmailService = jasmine.createSpyObj('EmailService', ['send_mail']);

    TestBed.configureTestingModule({
      declarations: [ForgetpasswordComponent],
      providers: [
        { provide: MdbModalRef, useValue: mockModalRef },
        { provide: EmailService, useValue: mockEmailService },
      ],
    });

    fixture = TestBed.createComponent(ForgetpasswordComponent);
    component = fixture.componentInstance;
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should send email', () => {
    const responseMessage = 'Email sent successfully';

    mockEmailService.send_mail.and.returnValue(of(responseMessage));

    component.email = 'test@example.com';
    component.send_mail();

    expect(mockEmailService.send_mail).toHaveBeenCalledWith('test@example.com');
    expect(mockModalRef.close).toHaveBeenCalled();
    expect(window.alert).toHaveBeenCalledWith(responseMessage);
  });
});
