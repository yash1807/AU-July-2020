import React, { createContext } from 'react';
import useLocalStorageReducer from '../hooks/useLocalStorageReducer';
import todosReducer from '../reducers/todos.reducer';

const defaultTodos = [
  { id: '0', task: 'Assignment' },
  { id: '1', task: 'Do Another Asignment' },
  { id: '2', task: 'Do One more Assignment' }
];

export const TodosContext = createContext();
export const DispatchContext = createContext();

export function TodosProvider(props) {
  const [todos, dispatch] = useLocalStorageReducer(
    'todos',
    todosReducer,
    defaultTodos
  );

  return (
    <TodosContext.Provider value={todos}>
      <DispatchContext.Provider value={dispatch}>
        {props.children}
      </DispatchContext.Provider>
    </TodosContext.Provider>
  );
}
