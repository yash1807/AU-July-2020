import React from "react";
import { createStackNavigator } from '@react-navigation/stack';
import { NavigationContainer } from '@react-navigation/native';

import Dashboard from "./src/components/Dashboard"
import Login from "./src/components/Login"

const Stack = createStackNavigator();

function App() {
  
  return (
    <NavigationContainer>
      <Stack.Navigator>
        <Stack.Screen name="Login" component={Login} options={{
          title: 'AU React Native',
          headerStyle: {
            backgroundColor: '#fedbd0',
          },
          headerTintColor: '#fff',
          headerTitleStyle: {
            color: 'black'
          },
        }} />
        <Stack.Screen name="Dashboard" component={Dashboard} options={{
          title: 'Your Todo List',
          headerStyle: {
            backgroundColor: '#fedbd0',
          },
          headerTintColor: '#fff',
          headerTitleStyle: {
            color: 'black'
          },
          headerLeft: null
        }}/>
      </Stack.Navigator>
    </NavigationContainer>
  );
}

export default App;