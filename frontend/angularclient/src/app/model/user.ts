export class User {
  username: string;
  password: string;
  email: string;
  role: string;

  constructor() {
    this.username = '';
    this.email = '';
    this.password = '';
    this.role = 'client';
  }
}
