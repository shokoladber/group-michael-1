
import './App.css'
import React from 'react';

    import ReactDOM from 'react-dom';
    
    import { Auth0Provider } from '@auth0/auth0-react';
    import App from './App';
    ReactDOM.render(
      <Auth0Provider
        domain="dev-cuxzun3pg8wwfwns.us.auth0.com"
        clientId="Gtk4PDcCbSddLUG8mZTZqmvPcGt2OCCB"
        authorizationParams={{
          redirect_uri: window.location.origin
        }}
    > 
      <App />
    </Auth0Provider>,
    document.getElementById('app')
 );



export default App
