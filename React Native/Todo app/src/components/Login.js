import React, { useState, useEffect } from "react";
import { Text, TextInput, View, StyleSheet, TouchableOpacity, AsyncStorage } from "react-native";

const Login = ({ navigation }) => {
    const [username, setUserName] = useState("");

    useEffect(() => {
        checkAuth()
    }, [])

    const checkAuth = async () => {
        const userName = await AsyncStorage.getItem("username");
        if (userName) {
            navigation.navigate("Dashboard");
        }
        return;
    }

    const login = async () => {
        await AsyncStorage.setItem("username", username);
        navigation.navigate("Dashboard");
    }

    return (
        <View style={Styles.container}>
            <Text style={Styles.loginTextStyle}>Login</Text>
            <TextInput style={Styles.textInputStyle} onChangeText={(text) => setUserName(text)} placeholder="Enter your username.." />
            <TouchableOpacity style={Styles.customBtnBG} onPress={login} >
            <Text color= 'black'>Submit</Text>
            </TouchableOpacity>
        </View>
    )
}


const Styles = StyleSheet.create({
    container: {
        flex: 1,
        justifyContent: "center",
        backgroundColor: "#F5FCFF",
        alignItems: "center"
    },
    loginTextStyle: {
        fontSize: 25,
        fontWeight: "700",
        marginVertical: 20
    },
    textInputStyle: {
        borderColor: "black",
        borderWidth: 1,
        borderRadius: 5,
        fontSize: 20,
        padding: 5,
        width: "60%",
        marginBottom: 20
    },
    customBtnBG: {
        backgroundColor: '#fedbd0',
        paddingHorizontal: 30,
        paddingVertical: 10,
        borderRadius: 15
    }
})

export default Login;