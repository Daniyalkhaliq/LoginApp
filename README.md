# LoginApp

Android application (Java + XML) with common screens: Splash, Login, Register, Forgot Password, Reset Password, Landing and Profile. Authentication is simulated locally with hardcoded values.

## Features
- Splash screen (ConstraintLayout) that opens Login after 2 seconds
- Login with input validation (default: `user@example.com` / `Password123`)
- Register with name, email, password and confirm password validation
- Forgot Password (simulated recovery) and Reset Password
- Landing screen with module cards in a GridLayout, each with an icon and text
- Profile screen showing user info with a Logout option
- Default and alternative resources: `strings.xml`, night-mode colors, Urdu strings, landscape layout

## Navigation flow
Splash → Login → (Register / Forgot Password → Reset Password → Login) → Landing → Profile → Logout → Login

## Technologies
Java, XML, Material Components, explicit Intents

## Author
Daniyal Khaliq (23108295), BS(AI) 5-C, SZABIST