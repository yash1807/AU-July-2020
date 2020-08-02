import React, { Component } from "react";
import {
  AppRegistry,
  StyleSheet,
  Text,
  View,
  FlatList,
  AsyncStorage,
  TouchableOpacity,
  TextInput,
  Keyboard,
  Platform,
  Alert,
  Button
} from "react-native";
import { Icon } from "native-base";

const isAndroid = Platform.OS == "android";
const viewPadding = 10;

export default class TodoList extends Component {

  state = {
    tasks: [],
    text: ""
  };

  changeTextHandler = text => {
    this.setState({ text: text });
  };

  addTask = () => {
    let notEmpty = this.state.text.trim().length > 0;

    if (notEmpty) {
      this.setState(
        prevState => {
          let { tasks, text } = prevState;
          return {
            tasks: tasks.concat({ key: tasks.length, text: text }),
            text: ""
          };
        },
        () => Tasks.save(this.state.tasks)
      );
      Alert.alert('Todo added');
    }
  };

  deleteTask = i => {
    this.setState(
      prevState => {
        let tasks = prevState.tasks.slice();

        tasks.splice(i, 1);

        return { tasks: tasks };
      },
      () => Tasks.save(this.state.tasks)
    );
    Alert.alert('Todo deleted');
  };

  componentDidMount() {
    Keyboard.addListener(
      isAndroid ? "keyboardDidShow" : "keyboardWillShow",
      e => this.setState({ viewPadding: e.endCoordinates.height + viewPadding })
    );

    Keyboard.addListener(
      isAndroid ? "keyboardDidHide" : "keyboardWillHide",
      () => this.setState({ viewPadding: viewPadding })
    );

    Tasks.all(tasks => this.setState({ tasks: tasks || [] }));
  }

    logout = async() => {
      await AsyncStorage.clear();
      this.props.navigation.navigate("Login");
  }
    


  render() {
    return (
      <View
        style={[styles.container, { paddingBottom: this.state.viewPadding }]}
      >
        <TextInput
          style={styles.textInput}
          onChangeText={this.changeTextHandler}
          onSubmitEditing={this.addTask}
          value={this.state.text}
          placeholder="Add a new task..."
          returnKeyType="done"
          returnKeyLabel="done"
        />
        <FlatList
          style={styles.list}
          data={this.state.tasks}
          renderItem={({ item, index }) =>
            <View>
              <View style={styles.listItemCont}>
                <Text style={styles.listItem}>
                  {item.text}
                </Text>
                <TouchableOpacity onPressOut={() => this.deleteTask(index.toString())}>
				        <Icon name='md-trash' style={{ color: '#eecbc0', paddingRight: 10 }} />
			          </TouchableOpacity>
              </View>
              <View style={styles.hr} />
            </View>}
        />
        <TouchableOpacity style={styles.customBtnBG} onPress={this.logout} >
          <Text color= 'black'>Logout</Text>
        </TouchableOpacity> 
      </View>
    );
  }
}

let Tasks = {
  convertToArrayOfObject(tasks, callback) {
    return callback(
      tasks ? tasks.split("||").map((task, i) => ({ key: i, text: task })) : []
    );
  },
  convertToStringWithSeparators(tasks) {
    return tasks.map(task => task.text).join("||");
  },
  all(callback) {
    return AsyncStorage.getItem("TASKS", (err, tasks) =>
      this.convertToArrayOfObject(tasks, callback)
    );
  },
  save(tasks) {
    AsyncStorage.setItem("TASKS", this.convertToStringWithSeparators(tasks));
  }
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: "center",
    alignItems: "center",
    backgroundColor: "#F5FCFF",
    padding: viewPadding,
    paddingTop: 20
  },
  list: {
    width: "100%",
    paddingTop: 15
  },
  listItem: {
    paddingTop: 2,
    paddingBottom: 2,
    fontSize: 18
  },
  hr: {
    height: 1,
    backgroundColor: "#cebbb0",
    paddingBottom: 2,
    marginBottom: 12
  },
  listItemCont: {
    flexDirection: "row",
    alignItems: "center",
    justifyContent: "space-between"
  },
  textInput: {
    height: 40,
    paddingRight: 10,
    paddingLeft: 10,
    borderColor: "black",
    borderWidth: 1,
    borderRadius: 5,
    width: "100%"
  },
  customBtnBG: {
    backgroundColor: '#fedbd0',
    paddingHorizontal: 30,
    paddingVertical: 10,
    borderRadius: 15,
    position: "absolute",
    bottom: 8,
    justifyContent: "center"
  }
});

AppRegistry.registerComponent("TodoList", () => TodoList);
