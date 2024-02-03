// Karma configuration
// Generated on Mon Oct 16 2023 15:06:46 GMT+0530 (India Standard Time)

module.exports = function (config) {
  config.set({

    // base path that will be used to resolve all patterns (eg. files, exclude)
    basePath: '',


    // frameworks to use
    // available frameworks: https://www.npmjs.com/search?q=keywords:karma-adapter
    frameworks: ['jasmine'],


    // list of files / patterns to load in the browser
    files: [

      'src/app/account/forgetpassword/forgetpassword.component.ts',

      'src/app/account/forgetpassword/forgetpassword.component.spec.ts',

      'src/app/account/login/login.component.ts',

      'src/app/account/login/login.component.spec.ts',

      'src/app/car-leasing-feedback/feedback/feedback.component.ts',

      'src/app/car-leasing-feedback/feedback/feedback.component.spec.ts',

      'src/app/crud/vehicleadd/vehicleadd.component.ts',

      'src/app/crud/vehicleadd/vehicleadd.component.spec.ts',

      'src/app/crud/vehicleadd/vehicleupdate.component.ts',

      'src/app/crud/vehicleadd/vehicleupdate.component.spec.ts',

      'src/app/crud/vehicleadd/vehicleview.component.ts',

      'src/app/crud/vehicleadd/vehicleview.component.spec.ts',

      'src/app/entities/user/user.component.ts',

      'src/app/entities/user/user.component.spec.ts',

      'src/app/exp/documentation/documentation.component.ts',

      'src/app/exp/documentation/documentation.component.spec.ts',

      'src/app/exp/entity/entity.component.ts',

      'src/app/exp/entity/entity.component.spec.ts',

      'src/app/exp/download/download.component.ts',

      'src/app/exp/download/download.component.spec.ts',

      'src/app/fileexp/lease-agreement-form/lease-agreement-form.component.ts',

      'src/app/fileexp/lease-agreement-form/lease-agreement-form.component.spec.ts',

      'src/app/payment/payment.component.ts',

      'src/app/payment/payment.component.spec.ts',

      'src/app/reservation/reservation.component.ts',

      'src/app/reservation/reservation.component.spec.ts',

      'src/app/app.component.ts',

      'src/app/app.component.spec.ts'

    ],


    // list of files / patterns to exclude
    exclude: [
    ],


    // preprocess matching files before serving them to the browser
    // available preprocessors: https://www.npmjs.com/search?q=keywords:karma-preprocessor
    preprocessors: {
    },


    // test results reporter to use
    // possible values: 'dots', 'progress'
    // available reporters: https://www.npmjs.com/search?q=keywords:karma-reporter
    reporters: ['progress'],


    // web server port
    port: 9876,


    // enable / disable colors in the output (reporters and logs)
    colors: true,


    // level of logging
    // possible values: config.LOG_DISABLE || config.LOG_ERROR || config.LOG_WARN || config.LOG_INFO || config.LOG_DEBUG
    logLevel: config.LOG_INFO,


    // enable / disable watching file and executing tests whenever any file changes
    autoWatch: true,


    // start these browsers
    // available browser launchers: https://www.npmjs.com/search?q=keywords:karma-launcher
    browsers: ['Chrome'],


    // Continuous Integration mode
    // if true, Karma captures browsers, runs the tests and exits
    singleRun: false,

    // Concurrency level
    // how many browser instances should be started simultaneously
    concurrency: Infinity
  })
}
