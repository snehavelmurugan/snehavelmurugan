import { User } from "./user";



describe('User', () => {

  let user: User;



  beforeEach(() => {

    user = new User();

  });



  it('should create an instance', () => {

    expect(user).toBeTruthy();

  });



  it('should have default values', () => {

    expect(user.username).toEqual('');

    expect(user.name).toEqual('');

    expect(user.email).toEqual('');

    expect(user.license_number).toEqual('');

    expect(user.password).toEqual('');

    expect(user.token).toEqual('');

  });

});



