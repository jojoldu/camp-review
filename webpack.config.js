/**
 * Created by jojoldu@gmail.com on 2017. 6. 13.
 * Blog : http://jojoldu.tistory.com
 * Github : http://github.com/jojoldu
 */

const webpack = require('webpack');
const path = require('path');
const ExtractTextPlugin = require('extract-text-webpack-plugin');
const extractCSS = new ExtractTextPlugin('css/build/build.css');

const extractCommons = new webpack.optimize.CommonsChunkPlugin({
    name: 'commons',
    filename: 'common.js'
});

const uglifyJsPlugin = new webpack.optimize.UglifyJsPlugin({
    compressor: {
        screw_ie8: true,
        warnings: false
    },
    output: {
        comments: false
    }
});

const defaultPath = 'src/main/resources/static';

const config = {
    context: path.resolve(__dirname, defaultPath),
    entry: './app.js',
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
                test: /\.css$/,
                loader: extractCSS.extract(['css-loader'])
            },
            {
                test: /\.(png|jpg|jpeg|gif)$/,
                loader: "file-loader?name=css/build/image/[name].[ext]"
            },
            {
                test: /\.(svg|woff|woff2|ttf|eot)$/,
                loader: "file-loader?name=css/build/fonts/[name].[ext]"
            }
        ],
    },
    plugins: [
        extractCSS
    ]
};

module.exports = config;

