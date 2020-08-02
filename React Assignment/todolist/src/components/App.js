import React from 'react';
import TodoApp from './TodoApp';
import useStyles from '../styles/AppStyles';

function App() {
  const classes = useStyles();

  return (
    <div className={classes.App}>
      <header className={classes.header}>
        <h1>
          Todo<span>list</span>
        </h1>
        <h2>AU react assignment by Yash</h2>
      </header>
      <TodoApp />
    </div>
  );
}

export default App;
