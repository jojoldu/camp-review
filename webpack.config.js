/**
 * Created by jojoldu@gmail.com on 2017. 6. 13.
 * Blog : http://jojoldu.tistory.com
 * Github : http://github.com/jojoldu
 */

const webpack = require('webpack');
const path = require('path');
const ExtractTextPlugin = require("extract-text-webpack-plugin");
const extractCommons = new webpack.optimize.CommonsChunkPlugin({
    name: 'commons',
    filename: 'common.js'
});
const extractCSS = new ExtractTextPlugin('[name].build.css');

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
        path: path.resolve(__dirname, defaultPath+'/build'),
        filename: 'build.js'
    },
    module: {
        rules: [{
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
        }]
    }
};

module.exports = config;

