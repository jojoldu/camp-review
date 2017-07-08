/**
 * Created by jojoldu@gmail.com on 2017. 6. 13.
 * Blog : http://jojoldu.tistory.com
 * Github : http://github.com/jojoldu
 */

const webpack = require('webpack');
const path = require('path');
const ExtractTextPlugin = require("extract-text-webpack-plugin");

const defaultPath = 'src/main/resources/static';

const config = {
    context: path.resolve(__dirname, defaultPath),
    entry: './js/app/app.js',
    output: {
        path: path.resolve(__dirname, defaultPath),
        filename: 'js/build/build.js'
    },
    module: {
        rules: [
            {
                test: /\.js$/,
                include: path.resolve(__dirname, defaultPath),
                use: [{
                    loader: 'babel-loader',
                    options: {
                        presets: [
                            ['es2015', {modules: false}]
                        ]
                    }
                }]
            },
            {
                test: /\.scss$/,
                use: ExtractTextPlugin.extract({
                    fallback: "style-loader",
                    use: "css-loader"
                })
            },
            {
                test: /\.(png|jpg|jpeg|gif)$/,
                loader: "file-loader?name=/css/build/image/[name].[ext]"
            },
            {
                test: /\.(svg|woff|woff2|ttf|eot)$/,
                loader: "file-loader?name=/css/build/fonts/[name].[ext]"
            },
            {
                test: /\.hbs/,
                loader: "handlebars-loader"
            }
        ],
    },
    plugins: [
        new ExtractTextPlugin('css/build/build.css')
    ],
    devtool: 'inline-source-map',
    devServer: {
        historyApiFallback: true,
        compress: true,
        publicPath: '/',
        host: "0.0.0.0",
        port: 3000,
        proxy: {
            "**": "http://localhost:8080"
        }
    },
};

module.exports = config;

